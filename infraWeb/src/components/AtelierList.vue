<script>
export default {
  data() {
    return {
      idIt : "IT",
      idFr : "FR"
    }
  },
  methods: {
    fetchAtelierData() {

    }
  }
}
</script>
<template>
  <div class="flex flex-wrap justify-center">
    <div class="border-2 border-black p-2 bg-green-100 my-2 mx-6 w-5/12">
      <p class="font-bold">Atelier 1 : IT</p>
      <p class="my-2">
        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed aliquet egestas semper. Phasellus in nibh tincidunt
        urna suscipit feugiat id ut odio. Aenean lacinia bibendum lobortis. Integer placerat feugiat nulla. Morbi luctus
        vehicula felis. Duis nisi metus, viverra et finibus nec, porta in erat. Quisque enim sem, convallis eu
        diam.
      </p>
      <RouterLink :to="/atelier/ + this.idIt">
        <button class="bg-[#36A862] text-white p-2">Voir les détails</button>
      </RouterLink>
    </div>
    <div class="border-2 border-black p-2 bg-green-100 my-2 mx-6 w-5/12">
      <p class="font-bold">Atelier 2 : FR</p>
      <p class="my-2">
        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed aliquet egestas semper. Phasellus in nibh tincidunt
        urna suscipit feugiat id ut odio. Aenean lacinia bibendum lobortis. Integer placerat feugiat nulla. Morbi luctus
        vehicula felis. Duis nisi metus, viverra et finibus nec, porta in erat. Quisque enim sem, convallis eu
        diam.
      </p>
      <RouterLink :to="/atelier/ + this.idFr">
        <button class="bg-[#36A862] text-white p-2">Voir les détails</button>
      </RouterLink>
    </div>
    <div class="border-2 border-black p-2 bg-green-100 my-2 mx-6 w-5/12">
      <p class="font-bold">Atelier 3 : MEX</p>
      <p class="my-2">
        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed aliquet egestas semper. Phasellus in nibh tincidunt
        urna suscipit feugiat id ut odio. Aenean lacinia bibendum lobortis. Integer placerat feugiat nulla. Morbi luctus
        vehicula felis. Duis nisi metus, viverra et finibus nec, porta in erat. Quisque enim sem, convallis eu
        diam.
      </p>
      <button class="bg-[#36A862] text-white p-2">Voir les détails</button>
    </div>
    <div class="border-2 border-black p-2 bg-green-100 my-2 mx-6 w-5/12">
      <p class="font-bold">Atelier 4 : JP</p>
      <p class="my-2">
        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed aliquet egestas semper. Phasellus in nibh tincidunt
        urna suscipit feugiat id ut odio. Aenean lacinia bibendum lobortis. Integer placerat feugiat nulla. Morbi luctus
        vehicula felis. Duis nisi metus, viverra et finibus nec, porta in erat. Quisque enim sem, convallis eu
        diam.
      </p>
      <button class="bg-[#36A862] text-white p-2">Voir les détails</button>
    </div>
    <div class="border-2 border-black p-2 bg-green-100 my-2 mx-6 w-5/12">
      <p class="font-bold">Atelier 5 : GR</p>
      <p class="my-2">
        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed aliquet egestas semper. Phasellus in nibh tincidunt
        urna suscipit feugiat id ut odio. Aenean lacinia bibendum lobortis. Integer placerat feugiat nulla. Morbi luctus
        vehicula felis. Duis nisi metus, viverra et finibus nec, porta in erat. Quisque enim sem, convallis eu
        diam.
      </p>
      <button class="bg-[#36A862] text-white p-2">Voir les détails</button>
    </div>
    <div class="border-2 border-black p-2 bg-green-100 my-2 mx-6 w-5/12">
      <p class="font-bold">Atelier 6 : OR</p>
      <p class="my-2">
        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed aliquet egestas semper. Phasellus in nibh tincidunt
        urna suscipit feugiat id ut odio. Aenean lacinia bibendum lobortis. Integer placerat feugiat nulla. Morbi luctus
        vehicula felis. Duis nisi metus, viverra et finibus nec, porta in erat. Quisque enim sem, convallis eu
        diam.
      </p>
      <button class="bg-[#36A862] text-white p-2">Voir les détails</button>
    </div>
  </div>
</template>