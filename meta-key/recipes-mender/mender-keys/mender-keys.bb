SUMMARY = "Mender public key package"
DESCRIPTION = "Provides the Mender public key for artifact verification"
LICENSE = "CLOSED"
PR = "r0"

# Dépendances éventuelles
# DEPENDS = "..."

# Le fichier source est juste le fichier statique dans files/
SRC_URI = "file://public.key"

S = "${WORKDIR}"

# Installation
do_install() {
    # Crée le répertoire cible dans le rootfs
    install -d ${D}${sysconfdir}/mender
    # Copie la clé publique
    install -m 0644 ${WORKDIR}/public.key ${D}${sysconfdir}/mender/artifact-verify-key.pem
}

# Nettoyage et empaquetage
FILES_${PN} = "${sysconfdir}/mender/artifact-verify-key.pem"
