<template>
  <v-navigation-drawer
    v-bind="$attrs"
    width="256"
    mini-variant-width="76"
    color="secondary2"
    class="elevation-5"
    :mini-variant.sync="mini"
    permanent
    dark
    app
  >
    <v-list
      dense
      nav
    >
      <v-list-item class="px-2">
        <v-list-item-avatar>
          <v-img src="https://randomuser.me/api/portraits/men/85.jpg" />
        </v-list-item-avatar>

        <v-list-item-title>John Leider</v-list-item-title>

        <v-btn
          icon
          @click.stop="mini = !mini"
        >
          <v-icon>mdi-chevron-left</v-icon>
        </v-btn>
      </v-list-item>

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
  data () {
    return {
      mini: false
    }
  },
  computed: {
    links () {
      return router.options.routes.filter(l => l.meta.isMainMenuItem)
    }
  }
}
</script>
