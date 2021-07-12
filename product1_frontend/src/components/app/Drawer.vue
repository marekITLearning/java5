<template>
  <v-navigation-drawer
    v-bind="$attrs"
    width="256"
    mini-variant-width="76"
    color="secondary2"
    class="elevation-5"
    :stateless="!$vuetify.breakpoint.xs"
    :permanent="!$vuetify.breakpoint.xs"
    :temporary="$vuetify.breakpoint.xs"
    dark
    app
  >
    <v-list
      dense
      nav
    >
      <v-list-item
        v-for="(link, idx) in links"
        :key="idx"
        :to="link.path"
        link
      >
        <v-list-item-icon>
          <v-icon>
            {{ link.meta.icon }}
          </v-icon>
        </v-list-item-icon>
        <v-list-item-content>
          <v-list-item-title>{{ $i18n.t(link.meta.label) }}</v-list-item-title>
        </v-list-item-content>
      </v-list-item>
    </v-list>
  </v-navigation-drawer>
</template>

<script>
import router from '@/plugins/router'

export default {
  name: 'Drawer',
  computed: {
    links () {
      return router.options.routes.filter(l => l.meta.isMainMenuItem)
    }
  }
}
</script>
