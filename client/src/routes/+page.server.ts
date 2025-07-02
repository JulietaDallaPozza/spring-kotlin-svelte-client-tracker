import type { Actions, PageServerLoad } from './$types';

const API_BASE = 'http://localhost:8080/api/clients';

export const load: PageServerLoad = async ({ fetch }) => {
  const res = await fetch(API_BASE);
  const clients = await res.json();
  return { clients };
};

export const actions: Actions = {
  default: async ({ request, fetch }) => {
    const formData = await request.formData();
    const data = {
      name: formData.get('name'),
      email: formData.get('email')
    };

    const res = await fetch(API_BASE, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(data)
    });

    if (!res.ok) {
      return { error: 'Failed to add client' };
    }

    return { success: true };
  }
};
