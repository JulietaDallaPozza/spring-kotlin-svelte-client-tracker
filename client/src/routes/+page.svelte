<script lang="ts">
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
{/if}
