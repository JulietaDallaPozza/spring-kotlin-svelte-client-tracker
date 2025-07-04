<!-- <script lang="ts">
  import { enhance } from "$app/forms";
  export let data;
</script>

<h1>Clients</h1>
<h2>Add Client</h2>


<form method="POST" use:enhance class="space-y-4">
  <input name="name" placeholder="Name" required class="input" />
  <input name="email" placeholder="Email" type="email" required class="input" />
  <input name="phone" placeholder="Phone" required class="input" />
<button
  type="submit"
  class="bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700 transition"
>
  Add Client
</button>
</form>

{#if data.clients && data.clients.length > 0}
  <ul>
    {#each data.clients as client}
      <li>{client.name} - {client.email}</li>
    {/each}
  </ul>
{:else}
  <p>No clients found</p>
{/if} -->

<script lang="ts">
  import { enhance } from "$app/forms";
  export let data;
</script>

<div class="min-h-screen bg-gray-100 flex items-center justify-center">
  <div
    class="bg-white rounded-2xl shadow-lg p-8 max-w-md w-full flex flex-col items-center"
  >
    <div class="flex flex-col items-center mb-6">
      <span class="i-carbon-user text-blue-600 text-3xl"></span>
      <h1 class="text-2xl font-bold text-gray-800 mt-2">Clients App Tracker</h1>
    </div>

    <form
      method="POST"
      use:enhance
      action="?/add"
      class="flex flex-col items-center gap-4 mb-8"
    >
      <input
        name="name"
        placeholder="Name"
        required
        class="w-72 px-4 py-2 rounded border border-gray-300 focus:border-blue-500 outline-none transition text-base"
      />
      <input
        name="email"
        placeholder="Email"
        type="email"
        required
        class="w-72 px-4 py-2 rounded border border-gray-300 focus:border-blue-500 outline-none transition text-base"
      />
      <button
        type="submit"
        class="w-72 bg-blue-600 text-white px-4 py-2 rounded font-semibold hover:bg-blue-700 transition flex items-center justify-center gap-2"
      >
        <span class="i-carbon-add"></span>
        Add Client
      </button>
    </form>
    <div
      class="border border-solid border-red-500 rounded-xl p-6rounded-xl shadow-inner p-6 w-full flex flex-col items-center"
    >
      <h2
        class="text-lg font-semibold text-gray-600 mb-3 flex items-center gap-2 justify-center"
      >
        <span class="i-carbon-list text-violet-500"></span> Client List
      </h2>

      {#if data.clients && data.clients.length > 0}
        <ul class="divide-y divide-gray-200 w-full">
          {#each data.clients as client}
            <li class="py-3 flex items-center gap-3 justify-between">
              <div class="flex items-center gap-3">
                <span class="i-carbon-user-avatar-filled text-blue-400 text-xl"
                ></span>
                <div>
                  <div class="font-medium text-gray-800">{client.name}</div>
                  <div class="text-sm text-gray-500">{client.email}</div>
                </div>
              </div>
              <form method="POST" use:enhance action="?/delete"> 
                <input type="hidden" name="id" value={client.id} />
                <button
                  type="submit"
                  name="delete"
                  value="1"
                  class="i-carbon-trash-can text-red-500 hover:text-red-700 text-2xl transition"
                  aria-label="Delete client"
                  title="Delete"
                ></button>
              </form>
            </li>
          {/each}
        </ul>
      {:else}
        <p class="text-gray-400 flex items-center gap-2 justify-center">
          <span class="i-carbon-warning-alt text-yellow-500"></span>
          No clients found
        </p>
      {/if}
    </div>
  </div>
</div>
