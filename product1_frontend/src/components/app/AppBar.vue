<template>
  <v-app-bar
    class="secondary2"
    elevate-on-scroll
    dark
    app
  >
    <v-app-bar-nav-icon
      @click.stop="switchDrawer"
    />

    <v-toolbar-title>
      MovieDB
    </v-toolbar-title>

    <v-spacer />

    <v-text-field
      flat
      solo-inverted
      hide-details
      prepend-inner-icon="mdi-magnify"
      append-icon="mdi-delete"
      :label="$i18n.t('$l.app.search')"
      class="pa-2"
      style="max-width:600px"
    />
  </v-app-bar>
</template>

<script>
export default {
  name: 'AppBar',
  data () {
    return {
      drawer: true
    }
  },
  methods: {
    switchDrawer () {
      this.drawer = !this.drawer
      this.$emit('switch-drawer', this.drawer)
    }
  }
}
</script>
