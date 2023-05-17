$(document).ready(function () {
    $('#employee-table').DataTable({
        ajax: {
            url: '/api/employee',
            dataSrc: ''
        },
        columns: [{
            data: null,
            render: function (data, type, row, meta) {
                return meta.row + meta.settings._iDisplayStart + 1;
            }
            },
            // {
            //     data: 'id'
            // },
            {
                data: 'nik'
            },
            {
                data: 'name'
            },
            {
                data: 'gender.labelGender',
                render: function (data, type, row, meta) {
                    if (data === 'P') {
                        return 'Perempuan';
                    } else if (data === 'L') {
                        return 'Laki-laki';
                    } else {
                        return '';
                    }
                }
            },
            {
                data: 'phone'
            },
            {
                data: 'email'
            },
            {
                data: 'address'
            },
            {
                data: 'department.name'
            },
            {
                data: 'manager.name'
            },
            {
                "data": null,
                render: function (data, row, type, meta) {
                    return `
                    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#detailModal"
                        onclick="countryDetail(${data.id})">
                        <i class="bi bi-exclamation-circle-fill"></i>
                    </button>
                    <button type="button" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#updateModal"
                        onclick="beforeUpdate(${data.id})">
                        <i class="bi bi-pencil-square"></i>
                    </button>
                    <button type="button" class="btn btn-danger"
                        onclick="countryDelete(${data.id})">
                        <i class="bi bi-trash3-fill"></i>
                    </button>
                    
                    `;
                }
            }
        ]
    });

    $.ajax({
        method: "GET",
        url: "api/department",
        dataType: "JSON",
        success: function (result) {
            $.each(result, function (key, value) {
                $('#department-input-name').append(
                    '<option value="' + value.id + '">' + value.name + '</option>'
                )
            })
        }
    });

    $.ajax({
        method: "GET",
        url: "api/employee",
        dataType: "JSON",
        success: function (result) {
            $.each(result, function (key, value) {
                $('#manajer-input-name').append(
                    '<option value="' + value.id + '">' + value.name + '</option>'
                )
                })
            }
        }) 
    });

    $.ajax({
        method: "GET",
        url: "api/employee",
        dataType: "JSON",
        success: function (result) {
            $.each(result, function (key, value) {
                var genderLabel = value.gender.labelGender;
                var genderText = '';
                
                if (genderLabel === 'P') {
                    genderText = 'Perempuan';
                } else if (genderLabel === 'L') {
                    genderText = 'Laki-laki';
                }
                
                $('#gender-input-name').append(
                    $('<option></option>').val(genderLabel).text(genderText)
                );
            });
        }
    });

$(document).ready({
    
})

function create() {
    let valNik = $('#employee-input-nik').val();
    let valName = $('#employee-input-name').val();
    let valGender = $('#gender-input-name option:selected').val() === 'Perempuan' ? 'P' : 'L';
    let valPhone = $('#employee-input-phone').val();
    let valEmail = $('#employee-input-email').val();
    let valAddress = $('#employee-input-address').val();
    let valDep = $('#department-input-name option:selected').val();
    let valMan = $('#manager-input-name option:selected').val();

    $.ajax({
        method: "POST",
        url: "api/employee",
        dataType: "JSON",
        data: JSON.stringify({
            nik: valNik,
            name: valName,
            gender: valGender,
            phone: valPhone,
            email: valEmail,
            address: valAddress,
            department: {
                name: valDep
            },
            manajer: {
                nik: valMan
            }
        }),
        contentType: "application/json",
        success: result => {
            console.log(result)
            $('#createModal').modal('hide')
            $('#employee-table').DataTable().ajax.reload()
            Swal.fire({
                position: 'top-center',
                icon: 'success',
                title: 'Employee has been saved',
                showConfirmButton: false,
                timer: 1500
            })
        }
    })
}

function beforeUpdate(id) {
    $.ajax({
        method: "GET",
        url: "api/employee/" + id,
        dataType: "JSON",
        success: function (result) {
            $('#employee-update-id').val(`${result.id}`)
            $('#employee-update-name').val(`${result.name}`)
            $('#employee-update-code').val(`${result.code}`)
            $('#employee-update-employee option[value="' + result.employee.id + '"]').attr('selected', 'selected');
        }
    })
}

function update() {
    let valId = $('#employee-update-id').val()
    let valName = $('#employee-update-name').val()
    let valCode = $('#employee-update-code').val()
    let valReg = $('#employee-update-employee option:selected').val()

    Swal.fire({
        title: 'Are you sure?',
        text: "Do you want to change this employee!",
        icon: 'question',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, Update it!'
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                method: "PUT",
                url: "api/employee/" + valId,
                dataType: "JSON",
                contentType: "application/json",
                data: JSON.stringify({
                    name: valName,
                    code: valCode,
                    employee: {
                        id: valReg
                    }
                }),
                success: result => {
                    $('#updateModal').modal('hide')
                    $('#employee-table').DataTable().ajax.reload()
                    Swal.fire({
                        position: 'top-center',
                        icon: 'success',
                        title: 'Successfully to Update',
                        showConfirmButton: false,
                        timer: 1500
                    })
                }
            })
        }
    })
}

function countryDelete(id) {
    Swal.fire({
        title: 'Are you sure?',
        text: "You won't be delete this employee!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                method: "DELETE",
                url: "api/employee/" + id,
                dataType: "JSON",
                success: result => {
                    $('#employee-table').DataTable().ajax.reload()
                    Swal.fire({
                        position: 'top-center',
                        icon: 'success',
                        title: 'Successfully to Delete',
                        showConfirmButton: false,
                        timer: 1500
                    })
                }
            })
        }
    })
}

function countryDetail(id) {
    $.ajax({
        method: "GET",
        url: "api/employee/" + id,
        dataType: "JSON",
        success: function (result) {
            $('#employee-detail-id').text(`${result.id}`)
            $('#employee-detail-name').text(`${result.name}`)
            $('#employee-detail-code').text(`${result.code}`)
            $('#employee-detail-employee').text(`${result.employee.name}`)
        }
    })
}