<script lang="ts">
  // import { enhance } from "$app/forms";
  export let data;
  console.log(data.clients);
</script>

<div class="max-h-screen flex items-center justify-center">
  <div
    class="bg-white rounded-2xl p-8 max-w-md w-full flex flex-col items-center"
  >
    <div class="flex flex-col items-center mb-6">
      <h1 class="mt-2 font-semibold text-blue-700">Clients App Tracker</h1>
    </div>

    <!-- add client form  -->
    <form
      method="POST"
      action="?/add"
      class="flex flex-col items-center gap-4 mb-8"
    >
      <input
        name="name"
        placeholder="Name"
        required
        class="w-72 px-4 py-2 rounded border border-blue-300 focus:border-blue-500 outline-none transition text-base"
      />
      <input
        name="email"
        placeholder="Email"
        type="email"
        required
        class="w-72 px-4 py-2 rounded border border-blue-300 focus:border-blue-500 outline-none transition text-base"
      />
      <button
        type="submit"
        class="w-72 bg-blue-500 text-white px-4 py-2 rounded font-semibold hover:bg-blue-600 transition flex items-center justify-center gap-2"
      >
        Add Client
      </button>
    </form>
    <div
      class="border border-solid border-blue-500 rounded-xl p-6rounded-xl shadow-inner p-6 w-full flex flex-col items-center"
    >
      <h2
        class="text-lg font-semibold text-blue-600 mb-3 flex items-center gap-2 justify-center"
      >
        <span class="font-semibold text-blue-600"></span> Client List
      </h2>

      {#if data.clients && data.clients.length > 0}
      <div class="w-full max-w-4xl mx-auto">
        <ul class=" w-full">
          {#each data.clients as client}
            <li class="flex flex-row justify-between items-center gap-2 py-3">
              <div class="flex items-center gap-1">
                <span class="text-blue-800 text-xl"></span>
                <div>
                  <div class="font-medium text-blue-800">{client.name}</div>
                  <div class="text-sm text-blue-500">{client.email}</div>
                </div>
              </div>
              <form method="POST" action="?/delete">
                <input type="hidden" name="id" value={client.id} />
                <button
                  type="submit"
                  name="delete"
                  value="1"
                  class="bg-blue-500 hover:bg-blue-600 text-white p-2 rounded"
                  aria-label="Delete client"
                  title="Delete"
                >
                  🗑️
                </button>
              </form>
            </li>
          {/each}
        </ul>
        </div>
      {:else}
        <p class="text-sm text-red-500">
          No clients found
        </p>
      {/if}
    </div>
  </div>
</div>
