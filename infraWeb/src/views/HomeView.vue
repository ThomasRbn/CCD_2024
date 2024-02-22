<template>
  <div class="home-view">
    <section class="hero-section">
      <div class="container">
        <div class="hero-content">
          <h1 class="hero-title">Boîte à cuisine située à Nancy !</h1>
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
            <img :src="`/img/${atelier.photo}`" :alt="atelier.nom" class="atelier-image">
            <h3>{{ atelier.nom }}</h3>
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

export default {
  components: {
    Atelier,
  },
  data() {
    return {
      ateliers: [
        {
          id: 1,
          nom: 'Bella Italia',
          photo: 'bella_italia.jpeg',
          cuisine: 'italienne',
          capacite: 15,
          creneau: 'mardi 5 mars midi'
        },
        {
          id: 2,
          nom: 'La Dolce Vita',
          photo: 'dolce_vita.webp',
          cuisine: 'italienne',
          capacite: 12,
          creneau: 'mercredi 6 mars midi'
        },
        {
          id: 3,
          nom: 'prime_secondi',
          photo: 'prime_secondi.jpeg',
          cuisine: 'italienne',
          capacite: 10,
          creneau: 'jeudi 7 mars midi'
        },
        {
          id: 4,
          nom: 'gusto_italiano',
          photo: 'gusto_italiano.jpeg',
          cuisine: 'italienne',
          capacite: 20,
          creneau: 'vendredi 8 mars midi'
        },
        {
          id: 5,
          nom: 'petit_bistro',
          photo: 'petit_bistro.jpeg',
          cuisine: 'française',
          capacite: 18,
          creneau: 'samedi 9 mars midi'
        },
        {
          id: 6,
          nom: 'La Cuisine Parisienne',
          photo: 'cuisine_parisienne.jpeg',
          cuisine: 'française',
          capacite: 15,
          creneau: 'dimanche 10 mars midi'
        },
        {
          id: 7,
          nom: 'Steak&frites',
          photo: 'steak_frites.jpeg',
          cuisine: 'française',
          capacite: 20,
          creneau: 'lundi 11 mars midi'
        },
        {
          id: 8,
          nom: 'Boulangerie et Pâtisserie',
          photo: 'patiseries.jpeg',
          cuisine: 'française',
          capacite: 25,
          creneau: 'mardi 12 mars midi'
        },
        {
          id: 9,
          nom: 'Fiesta Mexicana',
          photo: 'fiesta_mexicana.jpeg',
          cuisine: 'mexicaine',
          capacite: 20,
          creneau: 'mercredi 13 mars midi'
        },
        {
          id: 10,
          nom: 'Sabores de México',
          photo: 'sabores.jpeg',
          cuisine: 'mexicaine',
          capacite: 18,
          creneau: 'jeudi 14 mars midi'
        },
        {
          id: 11,
          nom: 'Cocina Mexicana',
          photo: 'cocina_mexicana.avif',
          cuisine: 'mexicaine',
          capacite: 15,
          creneau: 'vendredi 15 mars midi'
        },
        {
          id: 12,
          nom: 'Cocina de México',
          photo: 'cocina_mexico.jpeg',
          cuisine: 'mexicaine',
          capacite: 12,
          creneau: 'samedi 16 mars midi'
        },
        {
          id: 13,
          nom: 'Sushi Time',
          photo: 'sushi_time.jpeg',
          cuisine: 'japonaise',
          capacite: 15,
          creneau: 'dimanche 17 mars midi'
        },
        {
          id: 14,
          nom: 'Sushi Lovers',
          photo: 'sushi_lover.jpeg',
          cuisine: 'japonaise',
          capacite: 12,
          creneau: 'lundi 18 mars midi'
        },
        {
          id: 15,
          nom: 'Sushi Mania',
          photo: 'sushi_mania.jpeg',
          cuisine: 'japonaise',
          capacite: 18,
          creneau: 'mardi 19 mars midi'
        },
        {
          id: 16,
          nom: 'Sushi Bar',
          photo: 'sushi_bar.jpeg',
          cuisine: 'japonaise',
          capacite: 20,
          creneau: 'mercredi 20 mars midi'
        },
        {
          id: 17,
          nom: 'Gyros et Souvlaki',
          photo: 'souvlaki.jpeg',
          cuisine: 'grecque',
          capacite: 18,
          creneau: 'jeudi 21 mars midi'
        },
        {
          id: 18,
          nom: 'Mediterranean Flavors',
          photo: 'mediteran_grec.jpeg',
          cuisine: 'grecque',
          capacite: 20,
          creneau: 'vendredi 22 mars midi'
        },
        {
          id: 19,
          nom: 'Greek Taverna',
          photo: 'greektaverna.jpeg',
          cuisine: 'grecque',
          capacite: 16,
          creneau: 'samedi 23 mars midi'
        },
        {
          id: 20,
          nom: 'Greek Delicacies',
          photo: 'greek_delicacies.webp',
          cuisine: 'grecque',
          capacite: 14,
          creneau: 'dimanche 24 mars midi'
        },

        {
          id: 21,
          nom: 'Saveurs d\'Orient',
          photo: 'saveurs-orient.jpeg',
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
          photo: 'cuisine_maghreb.webp',
          cuisine: 'orientale',
          capacite: 18,
          creneau: 'mercredi 27 mars midi'
        },
        {
          id: 24,
          nom: 'Cuisine Libanaise',
          photo: 'cuisine_libanaise.jpeg',
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
      return Math.ceil(this.ateliers.length / this.pageSize);
    },
    paginatedAteliers() {
      const startIndex = (this.currentPage - 1) * this.pageSize;
      const endIndex = startIndex + this.pageSize;
      return this.ateliers.slice(startIndex, endIndex);
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
  },
};
</script>
<style scoped>
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
  margin-left: 130px;

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
  margin-left: 130px;
}

.section-title {
  font-size: 2rem;
  margin-bottom: 30px;
  color: #333;
  text-align: center;
}

.ateliers {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
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
  margin-bottom: 10px;
  width: 150px;
}

.atelier-card h3 {
  color: #333333;
  font-size: 1.5rem;
  margin-bottom: 5px;
}

.atelier-card p {
  color: #666666;
  font-size: 1rem;
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
