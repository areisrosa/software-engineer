<template>
    <div class="citations">
        <span>
            <button @click="number--">&lt;</button>
            <button @click="number++">&gt;</button>
        </span>
        <citation>
        <h1 slot="author">{{ citations[index].author }}</h1>
        <p slot="text">{{ citations[index].text }}</p>
        <h6 slot="font">{{ citations[index].font }}</h6>
        </citation>
    </div>
</template>

<script>
import Citation from './Citation.vue'

export default {
    components: { Citation },
    data() {
        return {
            number: 0,
            citations: [{
                font: 'Mother quotes',
                text: 'This is not room, it is a pigsty.',
                author: 'Roberta'
            }, {
                font: 'Phrases of Father',
                text: 'I will count until 3! 1, 2, 2...',
                author: 'Gustavo'
            }]
        }
    },
    computed: {
        index() {
            return Math.abs(this.number % 2)
        }
    }
}
</script>

<style scoped>
.citations {
    display: flex;
    flex-direction: column;
    align-items: center;
}
</style>
