<template>
    <div class="choice"
        @click="$emit('input', !value)"
         :class="{connected: value, disconnected: !valeu}">
        <div v-if="connected" class="button"></div>
        <div v-else class="button"></div>
    </div>
</template>

<script>
export default {
    props: {
        value: {
            type: Boolean,
            required: true
        }
    }
}
</script>

<style scoped>
.choice {
    position: relative;
    display: flex;
    flex-direction: column;
    justify-content: center;
    height: 15px;
    width: 40px;
    border-radius: 20px;
    border: 1px solid #aaa;
}

.button {
    position: absolute;
    margin: 0px 5px;
    height: 25px;
    width: 25px;
    border-radius: 14px;
    background: #fff;
    box-shadow: 0px 0px 5px #000b;
}

.disconnected {
    background-color: #aaa;
}

.connected {
    background-color: #7495c2;
}

.disconnected .button {
    left: -10px;
}

.connected .button {
    background-color: #255ca9;
    align-self: flex-end;
}
</style>
