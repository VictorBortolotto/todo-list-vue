<script setup>
    import "bootstrap-icons/font/bootstrap-icons.css";
    import Logo from '../components/logo/Logo.vue'
    import Item from '../components/item/Item.vue'
    import CardLists from '../components/card-lists/CardLists.vue'
</script>

<template>
    <div class="container"> 
        <header class="header"> 
            <Logo />
        </header>
        <nav class="navigation">

        </nav>
        <div class="content">
            <aside class="aside">
                <Item />
            </aside>   
            <section class="section">
                <CardLists />
            </section>   
        </div>
    </div>
</template>

<style>
    @import '../styles/Home.css';
</style>