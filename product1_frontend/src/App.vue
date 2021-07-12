<template>
  <v-app id="product1">
    <app-bar @switch-drawer="switchDrawer" />
    <app-drawer v-model="drawer" />
    <app-content />
    <app-footer />
  </v-app>
</template>

<script>
import locale from 'locale2'

export default {
  name: 'App',
  data () {
    return {
      drawer: true
    }
  },
  created () {
    this.$root.$i18n.locale = locale.split('-')[0]
  },
  methods: {
    switchDrawer (val) {
      this.drawer = val
    }
  },
  metaInfo () {
    return {
      htmlAttrs: {
        lang: this.$i18n.locale
      },
      meta: [
        {
          name: 'viewport',
          content: 'width=device-width, initial-scale=1'
        }, {
          'http-equiv': 'X-UA-Compatible',
          content: 'IE=edge'
        }],

      title: 'Product1',
      titleTemplate: (titleChunk) => {
        return titleChunk ? `DSBC | ${titleChunk}` : 'Product1'
      }
    }
  }
}
</script>

<style lang="scss" scoped>
  ::v-deep {.v-expansion-panel-content__wrap {
    padding: 0px 12px 12px 12px !important;
  }}
</style>

<style>
  .app_cursor_pointer {
    cursor: pointer;
  }
</style>
