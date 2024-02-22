<template>
  <div class="acceptation-affectations">
    <h1 class="page-title">Acceptation des Affectations</h1>
    <div class="affectations-list">
      <div v-for="(affectation, index) in displayedAffectations" :key="index" class="affectation-item">
        <div class="affectation-details">
          <h2 class="affectation-title">{{ affectation.title }}</h2>
          <p class="affectation-info">{{ affectation.date }}, {{ affectation.time }}</p>
          <p class="affectation-info">Utilisateur : {{ affectation.user }}</p>
        </div>
        <div class="acceptation-buttons">
          <button @click="acceptAffectation(affectation)" class="accept-button">Accepter</button>
          <button @click="refuseAffectation(affectation)" class="refuse-button">Refuser</button>
        </div>
      </div>
    </div>
    <div class="pagination">
      <button @click="previousPage" :disabled="currentPage === 1">Précédent</button>
      <button @click="nextPage" :disabled="currentPage === totalPages">Suivant</button>
    </div>
    <div v-if="showEmailInput" class="email-input">
      <label for="email">Entrez votre adresse e-mail :</label>
      <input type="email" id="email" v-model="userEmail" placeholder="Votre adresse e-mail">
      <button @click="confirmAction" class="confirm-button">Confirmer</button>
    </div>
    <div v-if="showConfirmationMessage" class="confirmation-message">
      <p>{{ confirmationMessage }}</p>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      affectations: [
        {
          title: "Cours de Cuisine Méditerranéenne",
          date: "10 janvier 2024",
          time: "15h00",
          user: "Jean Dupont"
        },
        {
          title: "Masterclass de Sushi et Sashimi",
          date: "12 janvier 2024",
          time: "10h00",
          user: "Marie Martin"
        },
        {
          title: "Atelier de Pâtisserie Française",
          date: "15 janvier 2024",
          time: "14h00",
          user: "Paul Durand"
        },
        {
          title: "Cours de Cuisine Japonaise Traditionnelle",
          date: "17 janvier 2024",
          time: "16h00",
          user: "Sophie Dubois"
        },
        {
          title: "Cours de Cuisine Mexicaine Authentique",
          date: "20 janvier 2024",
          time: "12h00",
          user: "Lucie Leroy"
        },
        {
          title: "Atelier de Cuisine Indienne Spécial Curry",
          date: "22 janvier 2024",
          time: "18h00",
          user: "Pierre Leclerc"
        },
        {
          title: "Cours de Pâtisserie Italienne Classique",
          date: "25 janvier 2024",
          time: "15h30",
          user: "Emma Martin"
        },
        {
          title: "Atelier de Cuisine Thaïlandaise Authentique",
          date: "27 janvier 2024",
          time: "11h30",
          user: "Lucas Lambert"
        },
        {
          title: "Masterclass de Sushi Fusion",
          date: "30 janvier 2024",
          time: "17h00",
          user: "Léa Petit"
        }
      ],
      currentPage: 1,
      affectationsPerPage: 5,
      showEmailInput: false,
      userEmail: "",
      showConfirmationMessage: false,
      confirmationMessage: ""
    };
  },
  computed: {
    displayedAffectations() {
      const startIndex = (this.currentPage - 1) * this.affectationsPerPage;
      const endIndex = startIndex + this.affectationsPerPage;
      return this.affectations.slice(startIndex, endIndex);
    },
    totalPages() {
      return Math.ceil(this.affectations.length / this.affectationsPerPage);
    }
  },
  methods: {
    acceptAffectation(affectation) {
      this.showEmailInput = true;
      this.confirmationMessage = "";
    },
    refuseAffectation(affectation) {
      this.showEmailInput = true;
      this.confirmationMessage = "";
    },
    confirmAction() {
      this.showEmailInput = false;
      this.confirmationMessage = "Action confirmée avec succès.";
    },
    previousPage() {
      if (this.currentPage > 1) {
        this.currentPage--;
      }
    },
    nextPage() {
      if (this.currentPage < this.totalPages) {
        this.currentPage++;
      }
    }
  }
};
</script>

<style scoped>
.acceptation-affectations {
  margin: 20px;
}

.page-title {
  font-size: 2rem;
  margin-bottom: 20px;
}

.affectations-list {
  display: grid;
  gap: 20px;
}

.affectation-item {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: #f9f9f9;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
}

.affectation-details {
  flex: 1;
}

.affectation-title {
  font-size: 1.5rem;
  margin-bottom: 5px;
}

.affectation-info {
  font-size: 1rem;
  color: #666666;
}

.acceptation-buttons {
  display: flex;
  align-items: center;
}

.accept-button, .refuse-button {
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.accept-button {
  background-color: #45a049;
  color: #ffffff;
}

.refuse-button {
  background-color: #f44336;
  color: #ffffff;
}

.accept-button:hover, .refuse-button:hover {
  background-color: #7fffd4;
}

.accept-button:active, .refuse-button:active {
  background-color: #00ced1;
}

.pagination {
  margin-top: 20px;
}

.pagination button {
  margin-right: 10px;
  padding: 8px 16px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  background-color: #f9f9f9;
  transition: background-color 0.3s ease;
}

.pagination button:hover {
  background-color: #eeeeee;
}

.pagination button:disabled {
  cursor: not-allowed;
  opacity: 0.5;
}

.email-input {
  margin-top: 20px;
}

.confirmation-message {
  margin-top: 20px;
  font-weight: bold;
}
</style>
