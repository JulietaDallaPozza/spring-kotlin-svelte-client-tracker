<script lang="ts">
  import { onMount } from 'svelte';
  import type { Client } from "$lib/types";

  let clients: Client[] = [];
  let loading = true;
  let error: string | null = null;

  let name = "";
  let email = "";
  let addError: string | null = null;

  // fetching clients from backend api
  async function loadClients() {
    loading = true;
    try {
      const res = await fetch("http://localhost:8080/api/clients");
      if (!res.ok) throw new Error("Failed to fetch clients");
      clients = await res.json();
      error = null;
    } catch (e) {
      if (e instanceof Error) {
        error = e.message;
      } else {
        error = String(e);
      }
    }
    loading = false;
  }

onMount(loadClients);

  async function addClient() {
    addError = null;
    try {
      const res = await fetch("http://localhost:8080/api/clients", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ name, email}),
      });
      if (!res.ok) throw new Error("Failed to add client");
      // Refresh the list
      await loadClients();
      // Clear the form
      name = "";
      email = "";
    } catch (e) {
      if (e instanceof Error) {
        error = e.message;
      } else {
        error = String(e);
      }
    }
  }
</script>

<h1>Clients</h1>
<h2>Add Client</h2>
<form on:submit|preventDefault={addClient}>
  <input placeholder="Name" bind:value={name} required />
  <input placeholder="Email" type="email" bind:value={email} required />
  <button type="submit">Add</button>
  {#if addError}
    <span style="color: red">{addError}</span>
  {/if}
</form>

{#if loading}
  <p>Loading...</p>
{:else if error}
  <p style="color: red">{error}</p>
{:else}
  <ul>
    {#each clients as client}
      <li>
        <strong>{client.name}</strong> — {client.email} 
      </li>
    {/each}
  </ul>
{/if}
