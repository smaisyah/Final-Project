function login() {
    const username = $('#username').val();
    const password = $('#password').val();
  
    // Validasi input username dan password
    if (username.trim() === '') {
      Swal.fire({
        icon: 'error',
        title: 'Error',
        text: 'Username tidak boleh kosong'
      });
      return;
    }
  
    if (password.trim() === '') {
      Swal.fire({
        icon: 'error',
        title: 'Error',
        text: 'Password tidak boleh kosong'
      });
      return;
    }
  
    // Kirim request ke server menggunakan AJAX
    $.ajax({
      url: '/api/login',
      type: 'POST',
      data: {
        username: username,
        password: password
      },
      success: function(response) {
        // Jika login berhasil, redirect ke halaman utama
        window.location.href = '@{/index}';
      },
      error: function(xhr, status, error) {
        // Jika login gagal, tampilkan pesan error
        Swal.fire({
          icon: 'error',
          title: 'Error',
          text: 'Username atau password salah'
        });
      }
    });
  }
  