<script>
</script>
<template>
  <header class="flex flex-row items-center justify-between bg-white p-2 drop-shadow-xl rounded-b-2xl">
    <img src="/img/icon.png" alt="logo" width="100"/>
    <div>
      <RouterLink to='/connexion' class="bg-green-boite hover:bg-purple-boite text-white font-bold py-2 px-4 rounded drop-shadow-md m-1 transition duration-500 ease-out">
        Connexion
      </RouterLink>
      <RouterLink to='/modif' class="bg-green-boite hover:bg-purple-boite text-white font-bold py-2 px-4 rounded drop-shadow-md m-1 transition duration-500 ease-out">
        Modification
      </RouterLink>
    </div>
  </header>
</template>