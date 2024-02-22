<template>
  <div class="home-view">

    <section class="hero-section">
      <div class="container">
        <div class="hero-content flex justify-center flex-col items-center">
          <h1 class="hero-title font-semibold">Boîte à cuisine située à Nancy ! 🍽️</h1>
          <img src="/img/AARS.png" class="drop-shadow-xl w-40" alt="Atelier de cuisine">
          <p class="hero-description">Découvrez nos prochains ateliers culinaires et réservez votre place dès maintenant.</p>
        </div>
      </div>
    </section>

    <!-- Ateliers Section -->
    <section class="ateliers-section">
      <div class="container">
        <h2 class="section-title">Liste des ateliers</h2>
        <div class="ateliers">

          <!-- Boucle pour afficher chaque atelier -->
          <div v-for="atelier in paginatedAteliers" :key="atelier.id" class="atelier-card" @click="showDetails(atelier)">
            <p class="font-bold text-xl">{{ atelier.nom }}</p>
            <p class="italic">{{ atelier.theme.nom }}</p>
            <p>Places restantes : {{ atelier.nbPlaces }}</p>
          </div>

        </div>
        <div class="pagination">
          <button @click="prevPage" :disabled="currentPage === 1" class="pagination-btn">Précédent</button>
          <button @click="nextPage" :disabled="currentPage === totalPages" class="pagination-btn">Suivant</button>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import Atelier from '@/components/Atelier.vue';
import {API_LIST_ATELIER} from "@/url.js";

export default {
  components: {
    Atelier,
  },
  data() {
    return {
      atelierData: "",
      ateliers: [
        {
          id: 1,
          nom: 'Bella Italia',
          photo: 'Atelier.webp',
          cuisine: 'italienne',
          capacite: 15,
          creneau: 'mardi 5 mars midi'
        },
        {
          id: 2,
          nom: 'La Dolce Vita',
          photo: 'Atelier.webp',
          cuisine: 'italienne',
          capacite: 12,
          creneau: 'mercredi 6 mars midi'
        },
        {
          id: 3,
          nom: 'Primi e Secondi',
          photo: 'Atelier.webp',
          cuisine: 'italienne',
          capacite: 10,
          creneau: 'jeudi 7 mars midi'
        },
        {
          id: 4,
          nom: 'Gusto Italiano',
          photo: 'Atelier.webp',
          cuisine: 'italienne',
          capacite: 20,
          creneau: 'vendredi 8 mars midi'
        },
        {
          id: 5,
          nom: 'Petit Bistro',
          photo: 'Atelier.webp',
          cuisine: 'française',
          capacite: 18,
          creneau: 'samedi 9 mars midi'
        },
        {
          id: 6,
          nom: 'La Cuisine Parisienne',
          photo: 'Atelier.webp',
          cuisine: 'française',
          capacite: 15,
          creneau: 'dimanche 10 mars midi'
        },
        {
          id: 7,
          nom: 'Atelier.webp',
          photo: 'Atelier.webp',
          cuisine: 'française',
          capacite: 22,
          creneau: 'lundi 11 mars midi'
        },
        {
          id: 8,
          nom: 'Boulangerie et Pâtisserie',
          photo: 'Atelier.webp',
          cuisine: 'française',
          capacite: 25,
          creneau: 'mardi 12 mars midi'
        },
        {
          id: 9,
          nom: 'Fiesta Mexicana',
          photo: 'Atelier.webp',
          cuisine: 'mexicaine',
          capacite: 20,
          creneau: 'mercredi 13 mars midi'
        },
        {
          id: 10,
          nom: 'Sabores de México',
          photo: 'Atelier.webp',
          cuisine: 'mexicaine',
          capacite: 18,
          creneau: 'jeudi 14 mars midi'
        },
        {
          id: 11,
          nom: 'Cocina Mexicana',
          photo: 'Atelier.webp',
          cuisine: 'mexicaine',
          capacite: 15,
          creneau: 'vendredi 15 mars midi'
        },
        {
          id: 12,
          nom: 'Cocina de México',
          photo: 'Atelier.webp',
          cuisine: 'mexicaine',
          capacite: 12,
          creneau: 'samedi 16 mars midi'
        },
        {
          id: 13,
          nom: 'Sushi Time',
          photo: 'Atelier.webp',
          cuisine: 'japonaise',
          capacite: 15,
          creneau: 'dimanche 17 mars midi'
        },
        {
          id: 14,
          nom: 'Sushi Lovers',
          photo: 'Atelier.webp',
          cuisine: 'japonaise',
          capacite: 12,
          creneau: 'lundi 18 mars midi'
        },
        {
          id: 15,
          nom: 'Sushi Mania',
          photo: 'Atelier.webp',
          cuisine: 'japonaise',
          capacite: 18,
          creneau: 'mardi 19 mars midi'
        },
        {
          id: 16,
          nom: 'Sushi Bar',
          photo: 'Atelier.webp',
          cuisine: 'japonaise',
          capacite: 20,
          creneau: 'mercredi 20 mars midi'
        },
        {
          id: 17,
          nom: 'Gyros et Souvlaki',
          photo: 'Atelier.webp',
          cuisine: 'grecque',
          capacite: 18,
          creneau: 'jeudi 21 mars midi'
        },
        {
          id: 18,
          nom: 'Mediterranean Flavors',
          photo: 'Atelier.webp',
          cuisine: 'grecque',
          capacite: 20,
          creneau: 'vendredi 22 mars midi'
        },
        {
          id: 19,
          nom: 'Greek Taverna',
          photo: 'Atelier.webp',
          cuisine: 'grecque',
          capacite: 16,
          creneau: 'samedi 23 mars midi'
        },
        {
          id: 20,
          nom: 'Greek Delicacies',
          photo: 'Atelier.webp',
          cuisine: 'grecque',
          capacite: 14,
          creneau: 'dimanche 24 mars midi'
        },

        {
          id: 21,
          nom: 'Saveurs d\'Orient',
          photo: 'Atelier.webp',
          cuisine: 'orientale',
          capacite: 20,
          creneau: 'lundi 25 mars midi'
        },
        {
          id: 22,
          nom: 'Cuisine Orientale',
          photo: 'Atelier.webp',
          cuisine: 'orientale',
          capacite: 15,
          creneau: 'mardi 26 mars midi'
        },
        {
          id: 23,
          nom: 'Cuisine du Maghreb',
          photo: 'Atelier.webp',
          cuisine: 'orientale',
          capacite: 18,
          creneau: 'mercredi 27 mars midi'
        },
        {
          id: 24,
          nom: 'Cuisine Libanaise',
          photo: 'Atelier.webp',
          cuisine: 'orientale',
          capacite: 12,
          creneau: 'jeudi 28 mars midi'
        }

      ],
      currentPage: 1,
      pageSize: 5,
    };
  },
  computed: {
    totalPages() {
      return Math.ceil(this.atelierData.length / this.pageSize);
    },
    paginatedAteliers() {
      const startIndex = (this.currentPage - 1) * this.pageSize;
      const endIndex = startIndex + this.pageSize;
      return this.atelierData.slice(startIndex, endIndex);
    },
  },
  methods: {
    showDetails(atelier) {
      alert(`${atelier.nom} : Cuisine ${atelier.cuisine}, Capacité : ${atelier.capacite} personnes, Créneau : ${atelier.creneau}`);
    },
    nextPage() {
      if (this.currentPage < this.totalPages) {
        this.currentPage++;
      }
    },
    prevPage() {
      if (this.currentPage > 1) {
        this.currentPage--;
      }
    },
    fetchAtelierData() {
      fetch(API_LIST_ATELIER)
          .then(response => response.json())
          .then(data => {
            this.atelierData = data;
          })
          .catch((error) => {
            console.log('erreur de chargement des données : ' + error);
          })
    },
  },
  mounted() {
    this.fetchAtelierData();
  }
};
</script>
<style scoped>
/* Header */

.container {
  width: 100%;
  margin: 0 auto;
  max-width: 1200px;
  padding: 0 20px;
}

.logo img {
  height: 50px;
  width: auto;
  margin-right: 10px;
}


.hero-section {
  background-color: #f9f9f9;
  padding: 60px 0;
  text-align: center;
  width: 100%;
  margin-left: 35px;

}

.hero-title {
  font-size: 3rem;
  margin-bottom: 20px;
  color: #333;
}

.hero-description {
  font-size: 1.5rem;
  color: #666;
  margin-bottom: 40px;
}

.ateliers-section {
  background-color: #f9f9f9;
  padding: 40px 0;
  width: 100%;
  margin-left: 35px;
}

.section-title {
  font-size: 2rem;
  margin-bottom: 30px;
  color: #333;
  text-align: center;
}

.ateliers {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
  gap: 20px;
  justify-items: center;
}

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

.atelier-card img {
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

.pagination {
  margin-top: 20px;
  text-align: center;
}

.pagination-btn {
  background-color: #4CAF50;
  color: white;
  padding: 10px 20px;
  font-size: 1.2rem;
  margin: 0 10px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.pagination-btn:disabled {
  background-color: #cccccc;
  cursor: not-allowed;
}

.pagination-btn:hover {
  background-color: #45a049;
}

</style>

