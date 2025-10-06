SUMMARY = "Install Mender artifact verification key"
LICENSE = "CLOSED"
SRC_URI = "file://public.key"

S = "${WORKDIR}"

do_install() {
    # Crée le répertoire /etc/mender dans l'image
    install -d ${D}${sysconfdir}/mender

    # Installe la clé sous le nom attendu par Mender
    install -m 0644 public.key ${D}${sysconfdir}/mender/artifact-verify-key.pem
}

# Indique à Yocto quel fichier doit être empaqueté
FILES_${PN} += "${sysconfdir}/mender/artifact-verify-key.pem"
