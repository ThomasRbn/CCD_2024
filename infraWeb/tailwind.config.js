/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx,vue}"
  ],
  theme: {
    extend: {
      colors: {
        'green-boite': '#2fac66',
        'purple-boite': '#a83683',
      },
    },
  },
  plugins: [],
}

