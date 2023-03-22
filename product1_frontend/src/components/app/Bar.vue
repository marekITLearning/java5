<template>
  <v-app-bar
    class="secondary2"
    elevate-on-scroll
    dark
    app
  >
    <v-toolbar-title>
      <div
        class="app_cursor_pointer"
        @click="$router.push('/').catch(e=>{})"
      >
        Program1
      </div>
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
  name: 'Bar',
  data () {
    return {
      drawer: true
    }
  }
}
</script>
