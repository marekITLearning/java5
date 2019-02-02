<template>
  <v-app>

    <!-- Top toolbar -->
    <app-toolbar />

    <!-- Left menu -->
    <app-menu />

    <!-- Main content -->
    <app-content />

  </v-app>
</template>

<script>
import AppToolbar from '@/components/App/AppToolbar'
import AppMenu from '@/components/App/AppMenu'
import AppContent from '@/components/App/AppContent'

export default {
  name: 'App',

  components: {
    AppToolbar,
    AppMenu,
    AppContent
  },

  metaInfo () {
    return {
      htmlAttrs: {
        lang: 'sk'
      },

      meta: [{
        charset: 'utf-8'
      }, {
        name: 'viewport',
        content: 'width=device-width, initial-scale=1'
      }, {
        'http-equiv': 'X-UA-Compatible',
        content: 'IE=edge'
      }],

      title: 'VUE-UI',

      titleTemplate: titleChunk => {
        return titleChunk ? `UI | ${titleChunk}` : 'VUE-UI'
      },

      link: [{
        rel: 'icon',
        href: '/public/favicon.ico'
      }]
    }
  }
}
</script>
