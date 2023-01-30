<template>
    <div class="card-container">
        <div class="card-header">
           <h1 class="card-title">{{ name }}</h1>
        </div>
    </div>
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
    @import './Card.css';
</style>