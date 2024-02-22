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
        'green-boite-light': '#8bd7ae',
        'purple-boite': '#24643d', // a83683
      },
    },
  },
  plugins: [],
}

