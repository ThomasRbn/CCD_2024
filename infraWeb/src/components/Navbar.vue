<template>
  <nav class="nav-bar">
    <RouterLink to='/voeux' class="nav-link">Mes voeux</RouterLink>
    <RouterLink to='/about' class="nav-link">À propos</RouterLink>
  </nav>
</template>

<style scoped>
.nav-bar {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 20px;
  width: 20%;
  background-color: #ffffff;
  background-image: linear-gradient(120deg, #84fab0 0%, #8fd3f4 100%);;
  border-left: 2px solid #22A6B3;
  border-radius: 0 10px 10px 0;
}

.nav-link {
  color: #333333;
  text-decoration: none;
  padding: 10px 20px;
  margin: 5px;
  border-radius: 5px;
  transition: background-color 0.3s ease;
}

.nav-link:hover {
  background-color: #6AB04A;
}
</style>
