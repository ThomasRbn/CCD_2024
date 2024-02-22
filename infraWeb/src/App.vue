<script setup>
import { RouterView } from 'vue-router'
import Header from '@/components/Header.vue'
import Navbar from '@/components/Navbar.vue'
import '@/assets/main.css'
</script>

<template>
    <div class="flex flex-col">
      <Header/>
      <div class="flex flex-row">
        <Navbar/>
        <RouterView />
      </div>
    </div>
</template>