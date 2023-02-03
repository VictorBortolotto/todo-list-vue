<template>
    <v-main class="main">
        <v-card class="card-itens">
            <ul class="list">
                <li class="list-item">
                    <v-btn id="button" >
                        <i class="bi bi-folder-plus"></i>
                        NEW DIRECTORY
                    </v-btn>
                </li>
                <li class="list-item">
                    <v-btn id="button" >
                        <i class="bi bi-person-fill-check"></i>
                        MY DIRECTORIES
                    </v-btn>
                </li>
            </ul>
        </v-card>
        <CardDirectory name="RECENT" icon="bi bi-clock-history"></CardDirectory>
    </v-main>
    
</template>

<script setup>
import CardDirectory from "@/common/cards/cardDirectories/CardDirectory.vue"
</script>

<style>
    .main {
        padding: 0px;
        margin: 0px;
        display: flex;
        flex-direction: row;
        align-items: center;
        justify-content: center;
        height: 100%;
        width: 100%;
    }

    .card-itens {
        padding: 0px;
        margin: 0px;
        width: 20%;
        height: 85%;
    }

    .list {
        list-style: none;
        height: 100%;
        width: 100%;
        background: white;
        margin: 0px;
        padding-inline-start: 0px;
    }

    .list-item {
        display: flex;
        align-items: center;
        justify-content: center;
        height: 10%;
        width: 100%;
    }

    #button {
        font-size: 16px;
        color: white;
        background: rgb(125, 125, 249);
        width: 90%;
        height: 70%;
    }

    #button:hover {
        background: rgb(166, 166, 209);
    }
</style>