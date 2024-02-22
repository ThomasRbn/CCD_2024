<script setup>
import { RouterView } from 'vue-router'
import '@/assets/main.css'
</script>

<template>
  <div class="flex flex-col">
    <Header/>
    <div class="flex flex-row">
      <RouterView />
    </div>
  </div>
</template>
