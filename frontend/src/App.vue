<script setup></script>

<template>
  <header>
    <div class="container">
      <h1>
        <router-link to="/">신청서 애플리케이션</router-link>
      </h1>
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
    font-weight: 500;
    a {
      color: inherit;
      text-decoration: none;

      &:hover {
        font-weight: 700;
      }
    }
  }
}

footer {
  padding: 30px 0;
  margin-top: 30px;
  border-top: 1px solid #ddd;
}
</style>
