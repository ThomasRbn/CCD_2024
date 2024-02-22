<template>
  <div class="atelier-card" @click="showDetails">
    <img :src="`/img/${atelier.photo}`" :alt="atelier.theme" class="atelier-image">
    <h3>{{ atelier.nom }}</h3>
  </div>
</template>

<script>
export default {
  props: ['atelier'],
  methods: {
    showDetails() {
      alert(`Détails de l'atelier ${this.atelier.theme} :
      \nCuisine: ${this.atelier.cuisine},
      \nCapacité: ${this.atelier.capacite},
      \nCréneau: ${this.atelier.creneau}`);
    }
  }
}
</script>

<style scoped>
.atelier-card {
  background-color: #ffffff;
  border-radius: 8px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  padding: 20px;
  text-align: center;
  transition: transform 0.3s ease;
}

.atelier-card:hover {
  transform: translateY(-5px);
}

.atelier-image {
  border-radius: 8px;
  margin-bottom: 15px;
  width: 100%;
}

.atelier-card h3 {
  color: #333333;
  font-size: 20px;
  margin-bottom: 10px;
}

.atelier-card p {
  color: #666666;
  font-size: 16px;
  margin-bottom: 5px;
}
</style>
