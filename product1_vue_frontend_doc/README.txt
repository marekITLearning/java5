open VSCode
cd c:/devel/projects/java5
npm init vue@latest product1_vue_frontend
follow next instructions until the project is created (add router and ESLint)
open folder product1_vue_frontend
open terminal and run
npm i
open package.json and replace "dev": "vite" with "dev": "vite --port 8080"
npm run dev
check the application in browser
stop the application (ctrl + c)
vue add quasar
follow instructions (confirm defaults, do not add sass variables)
npm i
npm run dev
