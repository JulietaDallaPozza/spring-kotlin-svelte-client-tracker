import { defineConfig, presetWind4 } from "unocss";
import presetAttributify from "@unocss/preset-attributify";
import presetIcons from "@unocss/preset-icons";

export default defineConfig({
  presets: [presetWind4(), presetAttributify(), presetIcons()],
});
