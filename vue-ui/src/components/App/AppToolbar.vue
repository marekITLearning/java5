<template>
  <v-toolbar color="primary" dark fixed app>

    <!-- Menu icon - "hamburger" -->
    <v-toolbar-side-icon @click.stop="$bus.$emit('switch_drawer')" />

    <!-- Company title or icon -->
    <v-toolbar-title>
      {{ this.$route.meta.title }}
    </v-toolbar-title>

  </v-toolbar>
</template>

<script>
export default {
  name: 'AppToolbar'
}
</script>

<style>
  .auto-width {
    width: auto !important;
  }
</style>
