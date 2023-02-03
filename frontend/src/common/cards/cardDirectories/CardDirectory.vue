<template>
    <div class="content">
        <v-card class="card-directory-home">
            <div class="card-content">
                <v-card-title id="title" >
                    <i :class="icon"></i>
                    {{ name }}
                </v-card-title>
                <v-card-text id="card-list">
                    <Card name="" description=""></Card>
                </v-card-text>
            </div>
           
        </v-card>
    </div>
</template>

<script setup>
import Card from "@/common/cards/card/Card.vue"

</script>

<script>
export default {
    props: {
        name: '',
        icon: ''
    }  
    
}

</script>


<style>
    .content {
        display: flex;
        align-items: center;
        justify-content: center;
        height: 85%;
        width: 70%;
    }

    .card-directory-home {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        height: 100%;
        width: 95%;
    }

    #title {
        display: flex;
        column-gap: 15px;
        align-items: center;
        background: white;
        font-size: 25px;
        height: 10%;
        width: 100%;
        color: gray;
    }

    #card-list {
        display: flex;
        height: 40%;
        width: 100%;
        column-gap: 10px;
    }

    .card-content {
        width: 100%;
        height: 100%;
    }
</style>