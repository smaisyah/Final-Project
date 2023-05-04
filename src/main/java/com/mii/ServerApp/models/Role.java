// package com.mii.ServerApp.models;

// import com.fasterxml.jackson.annotation.JsonProperty;
// import java.util.List;
// import javax.persistence.CascadeType;
// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.FetchType;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.JoinTable;
// import javax.persistence.ManyToMany;
// import javax.persistence.Table;
// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;
// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// @Entity
// @Table(name = "tb_role")
// public class Role {
//   @Id
//   @GeneratedValue(strategy = GenerationType.IDENTITY)
//   private Integer id;
//   @Column(nullable = false)
//   private String name;
//   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//   @ManyToMany(mappedBy = "roles")
//   private List<User> users;

//   @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//   @JoinTable(
//     name = "tb_role_privileges",
//     joinColumns = @JoinColumn(name = "role_id"),
//     inverseJoinColumns = @JoinColumn(name = "privilege_id")
//   )
//   private List<Privilege> privileges;
// }
