<template>
  <header class="header">
    <div class="logo-container">
      <img src="/img/icon.png" alt="logo" class="logo" />
      <h1 class="site-title">CookingBooking</h1>
    </div>
    <div class="nav-links">
      <RouterLink to='/connexion' class="nav-link">Connexion</RouterLink>
      <RouterLink to='/modif' class="nav-link">Modification</RouterLink>
    </div>
  </header>
</template>

<style scoped>
.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: #ffffff;
  background-image: linear-gradient(120deg, #84fab0 0%, #8fd3f4 100%);
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
