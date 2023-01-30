<script setup>
import Card from '../card/Card.vue'
</script>

<template>
    <div class="card-lists-container">
        <div class="card-list-content">
            <div class="card-lists-title">
                <i id="clock-icon" class="bi bi-clock" style=""></i>
                <div class="title">
                    <h2 style="color: gray;">Recently</h2>
                </div>
            </div>
            <div class="card-lists-recently-content">
                <Card name=""/>
            </div>
            <div class="card-lists-title">
                <i class="bi bi-person" style="display: flex; align-items: center; justify-content: center; height: 100%; font-size: 30px; color: gray; width: 4%;"></i>
                <div class="title">
                    <h2 style="color: gray;">Mine</h2>
                </div>
            </div>
            <div class="card-lists-recently-content">
                <Card name=""/>
            </div>
        </div>
    </div>
</template>


<style>
@import './CardLists.css';
</style>