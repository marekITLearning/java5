<template>
  <div
    v-if="callResult.finished === false || callResult.error !== null || callResult.info !== null"
  >
    <v-card
      class="ma-0 pa-1 text-center"
      outlined
      tile
      style="border-radius: 0.3em;"
    >
      <v-progress-circular
        v-if="callResult.finished === false"
        color="primary"
        indeterminate
        size="22"
        width="3"
        class="mr-3"
      />
      <span
        v-if="callResult.error !== null"
        class="error--text body-2"
      >
        {{ callResult.error }}
      </span>
      <span
        v-if="callResult.info !== null"
        class="info1--text body-2"
      >
        {{ callResult.info }}
      </span>
      <slot />
    </v-card>
  </div>
</template>

<script>
export default {
  name: 'ApiCall',
  props: {
    callResult: {
      type: Object,
      required: true
    }
  }
}
</script>
