<template>
    <v-card id="card">
        <v-card-title id="card-title">
            {{ name }}
        </v-card-title>
        <v-card-text id="card-text">
            {{ description }}
        </v-card-text>
    </v-card>
</template>

<script>
export default {
    props: {
        name: '',
        description: ''
    }
}
</script>

<style>
    #card{
        height: 70%;
        width: 30%;
        color: white;
        background: rgb(125, 125, 249);
    }

    #card:hover {
        background: rgb(166, 166, 209);
    }

    #card-title {
        height: 20%;
    }

    #card-text {
        height: 80%;
    }
</style>