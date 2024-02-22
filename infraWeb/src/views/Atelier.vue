<script>
export default {
  data() {
    return {
      id: "test"
    }
  },
  methods: {
    /**
     * Méthode qui récupère l'id de l'atelier de l'url
     */
    getAtelierID() {
      let url = window.location.href;
      return url.substring(url.lastIndexOf('/') + 1);
    }
  }
}
</script>
<template>
  <div class="w-5/6 p-8">
    <p><strong>ID de l'atelier : </strong>{{ this.getAtelierID() }}</p>
  </div>
</template>