<template>
    <v-app>
        <v-app-bar class="d-flex align-center justify-center" elevation="1" style="background-color: rgb(125, 125, 249);" app></v-app-bar>
        <v-main>
            <div class="container">
                <CardItens />
            </div>
        </v-main>
    </v-app>
</template>

<script setup>
import CardItens from '@/common/cards/cardItens/CardItens.vue'
</script>

<style>
@import './HomeComponent.css';
</style>