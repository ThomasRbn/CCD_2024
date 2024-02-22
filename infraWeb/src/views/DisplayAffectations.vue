<template>
  <div class="page-container">
    <div class="page-header">
      <h1 class="page-title">Affectations aux prochains ateliers</h1>
    </div>
    <div class="workshops-container">
      <div v-for="(workshop, index) in workshops" :key="index" class="workshop-card">
        <div class="workshop-details">
          <h2 class="workshop-title">{{ workshop.title }}</h2>
          <p class="workshop-info">{{ workshop.date }}, {{ workshop.time }}</p>
          <p class="workshop-info">{{ workshop.cuisine }}</p>
        </div>
        <div class="assigned-users">
          <h3 class="assignment-title">Utilisateurs affectés :</h3>
          <div v-for="(user, idx) in workshop.users" :key="idx" class="user-avatar">
            <img src="/img/user.avatar.png" :alt="user.name" class="avatar">
            <p class="user-name">{{ user.name }}</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      workshops: [
        {
          id: 1,
          title: "La Bella Cucina",
          date: "Programmé au 10 janvier 2024",
          time: "15h00",
          cuisine: "Cuisine Italienne",
          users: [
            { name: "Jean Dupont" },
            { name: "Marie Martin" }
          ]
        },

        {
          id: 2,
          title: "Sakura Sushi & Sashimi",
          date: "Programmé au 12 janvier 2024",
          time: "10h00",
          cuisine: "Cuisine Japonaise",
          users: [
            { name: "Jean Dupont" },
            { name: "Marie Martin" },
            { name: "Paul Durand" }
          ]
        },

        {
          id: 3,
          title: "Délices de France",
          date: "Programmé au 15 janvier 2024",
          time: "14h00",
          cuisine: "Cuisine Française",
          users: [
            { name: "Jean Dupont" },
            { name: "Marie Martin" },
            { name: "Paul Durand" },
            { name: "Sophie Dubois" }
          ]
        }

      ]
    };
  }
};
</script>

<style scoped>
.page-container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 20px;
}

.page-header {
  background-color: #6c757d;
  padding: 20px;
  border-radius: 10px;
  margin-bottom: 30px;
  text-align: center;
}

.page-title {
  font-size: 2rem;
  color: #ffffff;
  margin-bottom: 0;
}

.workshops-container {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
  gap: 20px;
}

.workshop-card {
  background-color: #ffffff;
  border-radius: 10px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  padding: 20px;
}

.workshop-details {
  margin-bottom: 20px;
}

.workshop-title {
  font-size: 1.5rem;
  color: #333333;
  margin-bottom: 10px;
}

.workshop-info {
  font-size: 1rem;
  color: #666666;
  margin-bottom: 5px;
}

.assigned-users {
  margin-bottom: 20px;
}

.assignment-title {
  font-size: 1.2rem;
  color: #333333;
  margin-bottom: 10px;
}

.user-avatar {
  display: flex;
  align-items: center;
  margin-bottom: 5px;
}

.avatar {
  width: 30px;
  height: 30px;
  border-radius: 50%;
  margin-right: 10px;
}

.user-name {
  font-size: 1rem;
  color: #333333;
}
</style>
