<script lang="ts">
  import 'uno.css'
</script>



<main class="p-6 max-h-screen overflow-y-auto">
  <slot />

</main>

<footer class="text-center text-blue-500 mt-10 mb-4">
  © 2025 Client App Tracker Company

</footer>


<style>
    :global(html, body) {
        font-family: 'Segoe UI',-apple-system, BlinkMacSystemFont, Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;
    }
    :global(button:hover) {cursor: pointer;}
</style>