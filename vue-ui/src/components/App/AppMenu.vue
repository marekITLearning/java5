<template>
  <section>
    <v-navigation-drawer v-model="drawer" fixed app class="primary99">

      <!-- Menu items list generated from routes -->
      <v-list>
        <v-list-tile v-for="(route, idx) in routes" :key="idx" :to="route.path">
          <v-list-tile-action>
            <v-icon>{{ route.meta.icon }}</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title class="title">{{ route.meta.title }}</v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>
      </v-list>

    </v-navigation-drawer>
  </section>
</template>

<script>
import routes from '@/plugins/router/routes'

export default {
  name: 'AppMenu',

  data () {
    return {
      drawer: false
    }
  },

  computed: {
    routes () {
      // Remove last route (error404)
      return routes.slice(0, -1)
    }
  },

  mounted () {
    // This fixes drawer not shown when application is first open
    // and persisted drawer state is false
    this.drawer = !this.$vuetify.breakpoint.mdAndDown
    this.$bus.$on('switch_drawer', () => { this.drawer = !this.drawer })
  },

  beforeDestroy () {
    this.$bus.$off('switch_drawer', () => { this.drawer = !this.drawer })
  }
}
</script>

<style>
  .v-list__tile--active {
    background: rgba(0,0,0,0.04);
  }
  .v-list__tile__title {
    color: rgba(0,0,0,0.70);
  }
</style>
