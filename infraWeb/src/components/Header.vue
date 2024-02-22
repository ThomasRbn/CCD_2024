<script>
import { defineComponent } from 'vue'
import { RouterLink } from 'vue-router'

export default defineComponent({
  components: {
    RouterLink
  },
  methods: {
    goHome() {
      this.$router.push('/')
    },
    goToAcceptation() {
      this.$router.push('/acceptation')
    }
  }
})
</script>

<template>
  <header class="header">
    <div @click="goHome" class="logo-container rounded-2xl bg-white pl-1 pr-1 cursor-pointer transition duration-300 ease-in-out transform hover:drop-shadow-md">
      <img src="/img/icon.png" alt="logo" class="logo" />
      <h1 class="site-title">CookingBooking</h1>
    </div>
    <div class="nav-links">
      <RouterLink to='/displayAffect' class="nav-link">Voir affectations</RouterLink>
      <RouterLink to='/acceptAffect' class="nav-link">Accepter affectations</RouterLink>
      <RouterLink to='/connexion' class="nav-link">Connexion</RouterLink>
      <RouterLink to='/modif' class="nav-link">Administrateur</RouterLink>
    </div>
  </header>
</template>

<style scoped>
.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: #ffffff;
  padding: 10px 20px;
  border-bottom: 2px solid #eeeeee;
}

.logo-container {
  display: flex;
  align-items: center;
}

.logo {
  width: 100px;
}

.site-title {
  color: #333333;
  font-size: 24px;
  font-weight: bold;
  margin-left: 10px;
}

.nav-links {
  display: flex;
}

.nav-link {
  color: #333333;
  text-decoration: none;
  padding: 10px;
  margin-left: 10px;
  border-radius: 5px;
  transition: background-color 0.3s ease;
}

.nav-link:hover {
  background-color: #eeeeee;
}
</style>
