<script setup></script>

<template>
  <header>
    <div class="container">
      <h1>신청서 애플리케이션</h1>
    </div>
  </header>
  <main>
    <div class="container">
      <router-view></router-view>
    </div>
  </main>
  <footer>
    <div class="container">&copy; 2025. Example. All rights reserved.</div>
  </footer>
</template>

<style lang="scss">
header {
  padding: 30px;
  border-bottom: 1px solid #ddd;
  margin-bottom: 30px;

  h1 {
    font-size: 20px;
    font-weight: bold;
  }
}

main {
  padding: 30px 0;
}

footer {
  padding-top: 30px;
  margin-top: 30px;
  border-top: 1px solid #ddd;
}
</style>
