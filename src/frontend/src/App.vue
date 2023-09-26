<template>

  <div id="app card">
    <div class=" card-header fs-20 fw-600 my-3 "><i class="mdi mdi-cards-playing fs-22"/> Jeux des cartes  <i class="mdi mdi-cards-playing fs-22"/></div>
    <div class="card-body">
      <router-view/>
    </div>
  </div>
    <footer id="footer" class="site-footer">
    <div class="container text-center">
      <span class="text-muted fs-12">
        <i class="mdi mdi-copyright" aria-hidden="true"></i>  Ayoub tigoudern 2023
      </span>
    </div>
  </footer>

</template>

<script>

export default {
  name: 'App',
}
</script>

<style>
#app {
  text-align: center;
  width: 100%;
  margin: 0px auto;
}

.site-footer {
  bottom: 36px;
  position: fixed;
}
</style>
