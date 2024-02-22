<script>

export default {
  data() {
    return {
      premierVoeuSelected: false,
      idPremierVoeu: "",
      idDeuxiemeVoeu: "",
      idTroisiemeVoeu: ""
    }
  },
  methods: {
    setPremierVoeu(id) {
      this.idPremierVoeu = id;
    },
    setDeuxiemeVoeu(id) {
      this.idDeuxiemeVoeu = id;
    },
    setTroisiemeVoeu(id) {
      this.idTroisiemeVoeu = id;
    }
  }
}
</script>
<template>
  <div class="w-5/6 p-8">
    <p class="font-bold text-2xl mb-4">Choix des voeux</p>
    <div class="flex flex-col">
      <div>
        <p>Mon premier choix : {{ this.idPremierVoeu }}</p>
        <div class="w-full">
          <button @click="setPremierVoeu('IT')" class="p-4 m-2 bg-green-100 w-[calc(100%/6 - 10px)]">Cuisine italienne</button>
          <button @click="setPremierVoeu('FR')" class="p-4 m-2 bg-green-100 w-[calc(100%/6 - 16px)]">Cuisine française</button>
          <button @click="setPremierVoeu('MEX')" class="p-4 m-2 bg-green-100 w-[calc(100%/6 - 16px)]">Cuisine sud-américaine</button>
          <button @click="setPremierVoeu('JP')" class="p-4 m-2 bg-green-100 w-[calc(100%/6 - 16px)]">Cuisine japonaise</button>
          <button @click="setPremierVoeu('GR')" class="p-4 m-2 bg-green-100 w-[calc(100%/6 - 16px)]">Cuisine grecque</button>
          <button @click="setPremierVoeu('OR')" class="p-4 m-2 bg-green-100 w-[calc(100%/6 - 16px)]">Cuisine orientale</button>
        </div>
      </div>
      <div>
        <p>Mon premier choix : {{ this.idDeuxiemeVoeu }}</p>
        <div class="w-full">
          <button @click="setDeuxiemeVoeu('IT')" class="p-4 m-2 bg-green-100 w-[calc(100%/6 - 10px)]">Cuisine italienne</button>
          <button @click="setDeuxiemeVoeu('FR')" class="p-4 m-2 bg-green-100 w-[calc(100%/6 - 16px)]">Cuisine française</button>
          <button @click="setDeuxiemeVoeu('MEX')" class="p-4 m-2 bg-green-100 w-[calc(100%/6 - 16px)]">Cuisine sud-américaine</button>
          <button @click="setDeuxiemeVoeu('JP')" class="p-4 m-2 bg-green-100 w-[calc(100%/6 - 16px)]">Cuisine japonaise</button>
          <button @click="setDeuxiemeVoeu('GR')" class="p-4 m-2 bg-green-100 w-[calc(100%/6 - 16px)]">Cuisine grecque</button>
          <button @click="setDeuxiemeVoeu('OR')" class="p-4 m-2 bg-green-100 w-[calc(100%/6 - 16px)]">Cuisine orientale</button>
        </div>
      </div>
      <div>
        <p>Mon premier choix : {{ this.idTroisiemeVoeu }}</p>
        <div class="w-full">
          <button @click="setTroisiemeVoeu('IT')" class="p-4 m-2 bg-green-100 w-[calc(100%/6 - 10px)]">Cuisine italienne</button>
          <button @click="setTroisiemeVoeu('FR')" class="p-4 m-2 bg-green-100 w-[calc(100%/6 - 16px)]">Cuisine française</button>
          <button @click="setTroisiemeVoeu('MEX')" class="p-4 m-2 bg-green-100 w-[calc(100%/6 - 16px)]">Cuisine sud-américaine</button>
          <button @click="setTroisiemeVoeu('JP')" class="p-4 m-2 bg-green-100 w-[calc(100%/6 - 16px)]">Cuisine japonaise</button>
          <button @click="setTroisiemeVoeu('GR')" class="p-4 m-2 bg-green-100 w-[calc(100%/6 - 16px)]">Cuisine grecque</button>
          <button @click="setTroisiemeVoeu('OR')" class="p-4 m-2 bg-green-100 w-[calc(100%/6 - 16px)]">Cuisine orientale</button>
        </div>
      </div>
    </div>
  </div>
</template>