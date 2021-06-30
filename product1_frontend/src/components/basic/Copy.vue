<template>
  <code class="d-flex ma-0 pa-0 mb-1">
    <v-card-text class="ma-0 pa-2">
      {{ toCopy }}
      <span class="accent--text text--darken-2">
        <slot />
      </span>
    </v-card-text>
    <v-spacer />
    <v-btn
      class="ma-0 pa-0"
      text
      icon
      aria-label="Copy code"
      @click.stop="copyToClipboard()"
    >
      <v-icon>mdi-content-copy</v-icon>
    </v-btn>
  </code>
</template>

<script>
export default {
  name: 'Base',
  props: {
    toCopy: {
      type: String,
      default: ''
    }
  },
  methods: {
    copyToClipboard () {
      const el = document.createElement('textarea')
      el.value = this.toCopy
      document.body.appendChild(el)
      el.select()
      var successful = document.execCommand('copy')
      if (successful) {
        this.snackbarConfig = { visible: true, color: 'info', title: 'Copied to clipboard', timeout: 1000 }
      } else {
        this.snackbarConfig = { visible: true, color: 'error', title: 'Failed to copty to clipboard', timeout: 0 }
      }
      document.body.removeChild(el)
    }
  }
}
</script>
