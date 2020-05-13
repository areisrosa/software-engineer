<template>
    <div cionss="citation">
        <slot name="font"></slot>
        <slot name="text"></slot>
        <slot name="author"></slot>
    </div>
</template>

<script>
export default {
    
}
</script>

<style scoped>
.citation {
    border: 1px solid #DDD;
    background-color: rgba(0, 0, 0, .1);
    padding: 25px;
    max-width: 450px;
}
h1 {
    color: red;
}
</style>
