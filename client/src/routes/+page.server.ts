import type { Actions, PageServerLoad } from "./$types";
//typescripts types from local module "types" pageserverload a type for functions that load data on the server before rendering a page**
// //a type for an object that defines server side actions (handling froms submissions)
const API_BASE = "http://localhost:8080/api/clients";

export const load: PageServerLoad = async ({ fetch }) => {
  const res = await fetch(API_BASE);
  const clients = await res.json();
  return { clients };
};

//load function**fetches a list of clients from the api before the page is rendered 
//bc is a server-rendered fw load function is used to fecth data the page need before rendering
//purpose data is available as soon as the page loads



export const actions: Actions = {
  default: async ({ request, fetch }) => {
    const formData = await request.formData();
    const data = {
      name: formData.get("name"),
      email: formData.get("email"),
    };

    const res = await fetch(API_BASE, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(data),
    }); //post request to api to create new client

    if (!res.ok) {
      return { error: "Failed to add client" };
    }

    return { success: true };
  },
};

//actions object handles server side form submissions (user interactions on the server improving secutiry & complex logic)