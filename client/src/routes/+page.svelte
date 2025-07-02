<script lang="ts">
  import { enhance } from '$app/forms';
  export let data;
</script>

<h1>Clients</h1>
<h2>Add Client</h2>
<form method="POST" use:enhance>
  <input name="name" placeholder="Name" required />
  <input name="email" placeholder="Email" type="email" required />
  <button type="submit">Add Client</button>
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
