import adapter from '@sveltejs/adapter-auto'
import { vitePreprocess } from '@sveltejs/vite-plugin-svelte'
import UnoCSS from '@unocss/svelte-scoped/preprocess'

const config = {
  preprocess: [
    vitePreprocess(),
    UnoCSS({
    }),
  ],
  kit: {
    adapter: adapter(),
  },
};

export default config;
